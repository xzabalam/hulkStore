import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import {
  MatDialog,
  MatDialogRef,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CarritoComprasStoreService } from 'src/app/compartidos/servicios/carrito-compras-store.service';
import { OrdenService } from '../../ordenes/servicios/orden.service';
import { CarritoComprasService } from '../servicios/carrito-compras.service';

@Component({
  selector: 'hulk-store-carrito-compras',
  templateUrl: './carrito-compras.component.html',
  styleUrls: ['./carrito-compras.component.css'],
})
export class CarritoComprasComponent implements OnInit {
  displayedColumns: string[] = [
    'imagen',
    'titulo',
    'cantidad',
    'valor',
    'subtotal',
    'accion',
  ];
  displayedDescuentoColumns = [
    'descuentoTitulo',
    'emptyFooter',
    'emptyFooter',
    'emptyFooter',
    'descuentoAmount',
    'emptyFooter',
  ];
  displayedSubtotalColumns = [
    'subTotalTitulo',
    'emptyFooter',
    'emptyFooter',
    'emptyFooter',
    'subTotalAmount',
    'emptyFooter',
  ];
  displayedIvaColumns = [
    'ivaTitulo',
    'emptyFooter',
    'emptyFooter',
    'emptyFooter',
    'ivaAmount',
    'emptyFooter',
  ];
  displayedTotalColumns = [
    'totalTitulo',
    'emptyFooter',
    'emptyFooter',
    'emptyFooter',
    'totalAmount',
    'emptyFooter',
  ];

  listadoCarritoCompras = [];
  dataSource = new MatTableDataSource<[]>();
  total: number = 0;
  subtotal: number = 0;
  iva: number = 0;
  descuento: number = 0;

  constructor(
    private readonly _carritoComprasStoreService: CarritoComprasStoreService,
    private readonly _carritoComprasService: CarritoComprasService,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this._carritoComprasStoreService.get().subscribe((producto) => {
      if (producto.length !== 0) {
        if (this.listadoCarritoCompras.indexOf(producto) === -1) {
          this.listadoCarritoCompras.push(producto);
          this.dataSource.data = this.listadoCarritoCompras;
          this.guardarProductoSeleccionadoEnDB(producto);
          this.calcularValoresTotales();
        } else {
          alert('Ya existe este producto en el carrito de compras');
        }
      }
    });

    this._carritoComprasService
      .obtenerProductosPorUsuarioInvitado()
      .subscribe((productos: []) => {
        if (null !== productos) {
          productos.forEach((producto: any) => {
            producto.existeEnBaseDatos = true;
            this._carritoComprasStoreService.push(producto);
          });
        }
      });
  }

  guardarProductoSeleccionadoEnDB(producto: any) {
    if (undefined === producto.existeEnBaseDatos) {
      this._carritoComprasService
        .persistirProductoEnCarritoCompras(producto)
        .subscribe((respuesta) => {});
    }
  }

  calcularSubtotalProducto(producto: any) {
    return producto.cantidadSeleccionada * producto.costoVenta;
  }

  calcularIva(producto: any) {
    return this.calcularSubtotalProducto(producto) * 0.12;
  }

  calcularValoresTotales() {
    if (this.dataSource.data.length > 0) {
      this.dataSource.data.forEach((producto: any) => {
        this.descuento = this.descuento + producto.descuento;
        this.subtotal = this.subtotal + this.calcularSubtotalProducto(producto);
        this.iva = this.iva + this.calcularIva(producto);
        this.total = this.total = this.subtotal + this.iva - this.descuento;
      });
    } else {
      this.descuento = 0;
      this.subtotal = 0;
      this.iva = 0;
      this.total = 0;
    }
  }

  eliminarProducto(producto: any) {
    this._carritoComprasService
      .eliminarProducto(producto.codigo)
      .subscribe(() => {
        this.listadoCarritoCompras.splice(producto, 1);
        this.dataSource.data = this.listadoCarritoCompras;

        this.calcularValoresTotales();
      });
  }

  pagarCompra() {
    const dialogRef = this.dialog.open(DialogCarritoComprasComponentDialog, {
      width: '500px',
      data: {
        total: this.total,
        subtotal: this.subtotal,
        impuesto: this.iva,
        descuento: this.descuento,
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result === 'pagado') {
        this.listadoCarritoCompras = [];
        this.dataSource.data = this.listadoCarritoCompras;
        this.calcularValoresTotales();
      }
    });
  }
}

export interface DialogData {
  total: number;
  subtotal: number;
  impuesto: number;
  descuento: number;
}

@Component({
  selector: 'dialogo-carrito-compras.component',
  template: `
    <h1 mat-dialog-title>Gracias por comprar en HulkStore!</h1>
    <div mat-dialog-content>
      <p>
        El valor total de tu compra es de <b>{{ data.total }}</b>
      </p>
      <p>Al aceptar el pago, se generara una órden de compra.</p>
    </div>
    <div mat-dialog-actions>
      <button mat-button (click)="onClickCancelar()">Cancelar</button>
      <button mat-raised-button color="primary" (click)="onClickPagar()">
        Pagar
      </button>
    </div>
  `,
})
export class DialogCarritoComprasComponentDialog implements OnDestroy {
  constructor(
    private readonly _router: Router,
    public dialogRef: MatDialogRef<DialogCarritoComprasComponentDialog>,
    private readonly _ordenService: OrdenService,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}

  onClickCancelar(): void {
    this.dialogRef.close('cancelado');
  }

  ngOnDestroy() {
    this._router.navigate(['/store']);
  }

  onClickPagar() {
    this._ordenService.persistirOrden(this.data).subscribe((respuesta) => {
      alert('Su órden se ha completado satisfactoriamente!');
      this.dialogRef.close('pagado');
    });
  }
}
