import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrdenesComponent } from './modulos/ordenes/componente/ordenes.component';
import { CategoriasComponent } from './modulos/categorias/componente/categorias.component';
import { DetalleProductoComponent } from './modulos/detalle-producto/componente/detalle-producto.component';
import { ProductosComponent } from './modulos/producto/componente/productos.component';

const routes: Routes = [
  { path: '', redirectTo: '/store', pathMatch: 'full' },
  {
    path: 'store',
    component: CategoriasComponent,
  },
  { path: 'productos/:idCategoria', component: ProductosComponent },
  { path: 'detalle-producto/:idProducto', component: DetalleProductoComponent },
  { path: 'ordenes', component: OrdenesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
