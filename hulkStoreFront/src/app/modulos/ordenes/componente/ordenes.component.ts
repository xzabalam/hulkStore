import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { OrdenService } from '../servicios/orden.service';

@Component({
  selector: 'hulk-store-ordenes',
  templateUrl: './ordenes.component.html',
  styleUrls: ['./ordenes.component.css'],
})
export class OrdenesComponent implements OnInit {
  listadoOrdenesActivas: any;
  panelOpenState: any;
  dataSource = new MatTableDataSource<[]>();

  constructor(private readonly _ordenService: OrdenService) {}

  ngOnInit(): void {
    this._ordenService.obtenerOrdenesActivas().subscribe((ordenes) => {
      this.listadoOrdenesActivas = ordenes;
    });
  }

  llenarDataSource(listadoProductos: any) {
    this.dataSource.data = listadoProductos;
    return this.dataSource;
  }
}
