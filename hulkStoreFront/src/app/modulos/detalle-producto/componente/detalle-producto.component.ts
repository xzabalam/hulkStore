import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CarritoComprasStoreService } from 'src/app/compartidos/servicios/carrito-compras-store.service';
import { DetalleProductoService } from '../servicios/detalle-producto.service';

@Component({
  selector: 'hulk-store-detalle-producto',
  templateUrl: './detalle-producto.component.html',
  styleUrls: ['./detalle-producto.component.css'],
})
export class DetalleProductoComponent implements OnInit {
  idProducto: any;
  producto: any;
  cantidadSeleccionada: number = 1;

  constructor(
    private readonly _activatedRoute: ActivatedRoute,
    private readonly _router: Router,
    private readonly _carritoComprasStoreService: CarritoComprasStoreService,
    private readonly _detalleProductoService: DetalleProductoService
  ) {}

  ngOnInit(): void {
    this._activatedRoute.params.subscribe((parametros: any) => {
      this.idProducto = parametros.idProducto;

      if (null === this.idProducto || '' === this.idProducto) {
        this._router.navigate(['/store']);
      } else {
        this._detalleProductoService
          .obtenerProductosPorCodigo(this.idProducto)
          .subscribe((producto) => {
            this.producto = producto;
          });
      }
    });
  }

  onClickAgregarCarritoCompras() {
    this.producto.cantidadSeleccionada = this.cantidadSeleccionada;
    this._carritoComprasStoreService.push(this.producto);
    this._router.navigate(['/store']);
  }
}
