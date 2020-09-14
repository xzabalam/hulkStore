import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { isUndefined } from 'util';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  private CONTENT_TYPE_JSON = 'application/json; charset=utf-8';

  constructor(private http: HttpClient) {}

  public postRequest(url: string, ruta: string, param: any) {
    const params =
      param === null || isUndefined(param) || param === '' ? {} : param;

    const headers = new HttpHeaders().set(
      'Content-Type',
      this.CONTENT_TYPE_JSON
    );

    return this.http.post(url + ruta, params, {
      headers,
    });
  }

  public getRequest(url: string, ruta: string) {
    const headers = new HttpHeaders().set(
      'Content-Type',
      this.CONTENT_TYPE_JSON
    );
    return this.http.get(url + ruta, {
      headers: headers,
    });
  }

  public deleteRequest(url: string, ruta: string) {
    const headers = new HttpHeaders().set(
      'Content-Type',
      this.CONTENT_TYPE_JSON
    );
    return this.http.delete(url + ruta, {
      headers: headers,
    });
  }

  public putRequest(url: string, ruta: string, params: any) {
    const headers = new HttpHeaders().set(
      'Content-Type',
      this.CONTENT_TYPE_JSON
    );
    return this.http.put(url + ruta, params, {
      headers: headers,
    });
  }
}
