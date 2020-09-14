import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { ConstanteGlobales } from 'src/app/compartidos/constantes/constante-globales';
import { HttpService } from 'src/app/compartidos/servicios/http-service';

@Injectable({
  providedIn: 'root',
})
export class ProductosService {
  constructor(private readonly httpService: HttpService) {}

  public obtenerProductosPorCategoria(idCategoria: any): Observable<any> {
    const ruta = '/productos/' + idCategoria;
    return this.httpService.getRequest(ConstanteGlobales.URL_REST, ruta);
  }
}
