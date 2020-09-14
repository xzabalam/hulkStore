import { Component, OnInit } from '@angular/core';
import { CategoriasService } from '../servicios/categorias.service';

@Component({
  selector: 'hulk-store-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css'],
})
export class CategoriasComponent implements OnInit {
  listadoCategoriasActivas: any;

  constructor(private readonly categoriaService: CategoriasService) {}

  ngOnInit(): void {
    this.categoriaService.obtenerActivas().subscribe((categorias) => {
      this.listadoCategoriasActivas = categorias;
    });
  }
}
