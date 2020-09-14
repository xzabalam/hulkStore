import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root',
})
export class CarritoComprasStoreService {
  private subjectCarrito = new BehaviorSubject<any>([]);

  get(): Observable<any> {
    return this.subjectCarrito;
  }

  push(data: any) {
    this.subjectCarrito.next(data);
  }
}
