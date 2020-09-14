import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './app-material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CategoriasComponent } from './modulos/categorias/componente/categorias.component';
import { ProductosComponent } from './modulos/producto/componente/productos.component';
import { DetalleProductoComponent } from './modulos/detalle-producto/componente/detalle-producto.component';
import { CommonModule } from '@angular/common';
import { CarritoComprasComponent } from './modulos/carrito-compras/componentes/carrito-compras.component';
import { OrdenesComponent } from './modulos/ordenes/componente/ordenes.component';

@NgModule({
  declarations: [
    AppComponent,
    CategoriasComponent,
    ProductosComponent,
    DetalleProductoComponent,
    CarritoComprasComponent,
    OrdenesComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
