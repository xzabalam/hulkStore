import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductosService } from '../servicios/productos.service';

@Component({
  selector: 'hulk-store-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css'],
})
export class ProductosComponent implements OnInit {
  idCategoria: any;
  listadoProductos: any;

  constructor(
    private readonly _activatedRoute: ActivatedRoute,
    private readonly _router: Router,
    private readonly _productosService: ProductosService
  ) {}

  ngOnInit(): void {
    this._activatedRoute.params.subscribe((parametros: any) => {
      this.idCategoria = parametros.idCategoria;

      if (null === this.idCategoria || '' === this.idCategoria) {
        this._router.navigate(['/store']);
      } else {
        this._productosService
          .obtenerProductosPorCategoria(this.idCategoria)
          .subscribe((productos) => {
            this.listadoProductos = productos;
          });
      }
    });
  }
}
