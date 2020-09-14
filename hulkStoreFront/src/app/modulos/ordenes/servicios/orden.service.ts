import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { ConstanteGlobales } from 'src/app/compartidos/constantes/constante-globales';
import { HttpService } from 'src/app/compartidos/servicios/http-service';

@Injectable({
  providedIn: 'root',
})
export class OrdenService {
  constructor(private readonly httpService: HttpService) {}

  persistirOrden(orden: any): Observable<any> {
    const ruta = '/orden';
    return this.httpService.postRequest(
      ConstanteGlobales.URL_REST,
      ruta,
      orden
    );
  }

  obtenerOrdenesActivas(): Observable<any> {
    const ruta = '/orden';
    return this.httpService.getRequest(ConstanteGlobales.URL_REST, ruta);
  }
}
