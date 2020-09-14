import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { ConstanteGlobales } from 'src/app/compartidos/constantes/constante-globales';
import { HttpService } from 'src/app/compartidos/servicios/http-service';

@Injectable({
  providedIn: 'root',
})
export class CarritoComprasService {
  constructor(private readonly httpService: HttpService) {}

  obtenerProductosPorCodigoCarrito(idCarritoCompras: any): Observable<any> {
    const ruta = '/carrito-compra/' + idCarritoCompras;
    return this.httpService.getRequest(ConstanteGlobales.URL_REST, ruta);
  }

  obtenerProductosPorUsuarioInvitado(): Observable<any> {
    const ruta = '/carrito-compra/';
    return this.httpService.getRequest(ConstanteGlobales.URL_REST, ruta);
  }

  eliminarProducto(codigoProducto: any): Observable<any> {
    const ruta = '/carrito-compra/' + codigoProducto;
    return this.httpService.deleteRequest(ConstanteGlobales.URL_REST, ruta);
  }

  persistirProductoEnCarritoCompras(produto: any): Observable<any> {
    const ruta = '/carrito-compra/';
    return this.httpService.postRequest(
      ConstanteGlobales.URL_REST,
      ruta,
      produto
    );
  }
}
