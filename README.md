# Configuración del código

Ejecturar los siguientes comandos:

```bash
git clone 
cd hulkStore
```

## Java
```bash
cd hulk.store

mvn clean install
```
Copiar el archivo hulk.store.web.war que se encuentra en la carpeta hulk.store.web\target en la carpeta standalone de servidor de aplicaciones Jboss EAP.  Ubicarse en la carpeta $JBOSS_HOME/bin y ejecutar el siguiente comando

```bash
standalone.bat -c standalone-full.xml
```

## Angular
```bash
cd hulkStoreFront
npm install
ng serve --open
```

Cambiar el archivo proxy.conf.json y modificar el puerto en el que se encuentra corriendo el aplicativo java (http://localhost:8580).

```json
{
  "/hulk.store.web/*": {
    "target": "http://localhost:8580",
    "secure": false,
    "logLevel": "debug"
  }
}
```

# Base de datos

![Base de datos](hulkStore/varios/db/HulkStoreFinal.PNG)

# ApiRest 

Descripción del api rest para el almacén Hulk

## Listar el catálogo activo 

Muestra todas las categorías que están activas en el almacén.

**URL** : `/rest/categorias`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Data constraints** : `{}`

### Respuesta de no contenido
**Condition** : No se encontraron datos

**Code** : `204 (No Content)`


### Respuesta de error
**Condition** : Se produjo un error al obtener las categorías

**Code** : `505 SERVER ERROR`

**Content** : `Se produjo un error al obtener las categorías`

### Respuestas satisfactorias

**Condición** : Listado de todas las categorías activas.

**Codigo** : `200 OK`

**Contenido** : Listado en formato json:

```json
[
    {
        "codigo": 1,
        "nombre": "Camisetas",
        "descripcion": "Descripción de categorias",
        "slug": "camisetas"
    },
    {
        "codigo": 2,
        "nombre": "Vasos",
        "descripcion": "Descripción de Vasos",
        "slug": "vasos"
    },
    {
        "codigo": 3,
        "nombre": "Comics",
        "descripcion": "Descripción de Comics",
        "slug": "comics"
    },
    {
        "codigo": 4,
        "nombre": "Juguetes",
        "descripcion": "Descripción de Juguetes",
        "slug": "juguetes"
    },
    {
        "codigo": 5,
        "nombre": "Accesorios",
        "descripcion": "Descripción de Accesorios",
        "slug": "accesorios"
    }
]
```

## Lista de productos por categoría 

Muestra todas los productos que tiene una categoría seleccionada

**URL** : `/rest/productos/{idCategoria}`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Data constraints** : `@PathParam {idCatgeoria}` 

### Respuesta de no contenido
**Condition** : No se encontraron datos

**Code** : `204 (No Content)`

### Respuesta de error
**Condition** : Se produjo un error al obtener los productos

**Code** : `505 SERVER ERROR`

**Content** : `Se produjo un error al obtener los productos`

### Respuestas satisfactorias

**Condición** : Listado de todos los productos.

**Codigo** : `200 OK`

**Contenido** : Listado en formato json:

```json
[
    {
        "codigo": 6,
        "titulo": "Camiseta 1",
        "resumen": "Resumen camiseta 1",
        "descripcion": "Descripcion camiseta 1",
        "urlImagen": "https://regalame.ec/wp-content/uploads/2019/03/camiseta-come-galletas.jpg",
        "cantidad": 100,
        "sku": null,
        "costoVenta": 250.0,
        "codigoCategoria": 2
    },
    {
        "codigo": 7,
        "titulo": "Camiseta 2",
        "resumen": "Resumen camiseta 2",
        "descripcion": "Descripcion camiseta 2",
        "urlImagen": "https://http2.mlstatic.com/confeccion-camisetas-manga-ranglan-algodon-para-sublimar-D_NQ_NP_997262-MEC31007462223_062019-Q.jpg",
        "cantidad": 100,
        "sku": null,
        "costoVenta": 250.0,
        "codigoCategoria": 2
    }
]
```

## Detalle de un producto por código 

Muestra el detalle de un producto buscado por código

**URL** : `/rest/productos/detalle/{idProducto}`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Data constraints** : `@PathParam {idProducto}` 

### Respuesta de no contenido
**Condition** : No se encontraron datos

**Code** : `204 (No Content)`

### Respuesta de error
**Condition** : Se produjo un error al obtener los productos

**Code** : `505 SERVER ERROR`

**Content** : `Se produjo un error al obtener el detalle del producto`

### Respuestas satisfactorias

**Condición** : Objeto con el detalle del producto buscado.

**Codigo** : `200 OK`

**Contenido** : Listado en formato json:

```json
{
    "codigo": 1,
    "titulo": "Camiseta 1",
    "resumen": "Resumen camiseta 1",
    "descripcion": "Descripcion camiseta 1",
    "urlImagen": "https://regalame.ec/wp-content/uploads/2019/03/camiseta-come-galletas.jpg",
    "cantidad": 100,
    "sku": null,
    "costoVenta": 250.0,
    "codigoCategoria": 1
}
```

## Almacenar un producto en el carrito de compra 

Guardar un producto seleccionado en el carrito de compra

**URL** : `/rest/carrito-compra`

**Method** : `PUT`

**Auth required** : NO

**Permissions required** : None

**Data constraints** : 

```json
{
    "codigo": 13,
    "titulo": "Comic 3",
    "resumen": "Resumen Comic 3",
    "descripcion": "Descripcion Comic 3",
    "urlImagen": "https://i.pinimg.com/originals/70/17/a1/7017a1599607337468080a3280af95f7.jpg",
    "cantidad": 100,
    "sku": "ABC-DEF_0001",
    "costoVenta": 250,
    "codigoCategoria": 3,
    "descuento": 10,
    "cantidadSeleccionada": 30
}
```

### Respuesta de error
**Condition** : No se pudo almacenar el producto

**Code** : `505 SERVER ERROR`

**Content** : `Se produjo un error al guardar el producto seleccionado`

### Respuestas satisfactorias

**Condición** : C[odigo del carrito de compra.

**Codigo** : `200 OK`

**Contenido** : 'codigoCarritoCompra'


## Obtener los productos almacenados en el carrito de compras 

Obtener el listado de productos almacenados en el carrito de compras

**URL** : `/rest/carrito-compra/{codigoCarritoCompra}`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Data constraints** : 'idCarritoCompra'

### Respuesta de no contenido
**Condition** : No se encontraron datos

**Code** : `204 (No Content)`

### Respuesta de error
**Condition** : Se produjo un error al obtener los productos

**Code** : `505 SERVER ERROR`

**Content** : `Se produjo un error al obtener los productos`

### Respuestas satisfactorias

**Condición** : C[odigo del carrito de compra.

**Codigo** : `200 OK`

**Contenido** : 

```json
[
    {
        "codigo": 6,
        "titulo": "Camiseta 1",
        "resumen": "Resumen camiseta 1",
        "descripcion": "Descripcion camiseta 1",
        "urlImagen": "https://regalame.ec/wp-content/uploads/2019/03/camiseta-come-galletas.jpg",
        "cantidad": 100,
        "sku": null,
        "costoVenta": 250.0,
        "codigoCategoria": 2
    },
    {
        "codigo": 7,
        "titulo": "Camiseta 2",
        "resumen": "Resumen camiseta 2",
        "descripcion": "Descripcion camiseta 2",
        "urlImagen": "https://http2.mlstatic.com/confeccion-camisetas-manga-ranglan-algodon-para-sublimar-D_NQ_NP_997262-MEC31007462223_062019-Q.jpg",
        "cantidad": 100,
        "sku": null,
        "costoVenta": 250.0,
        "codigoCategoria": 2
    }
]
```

# Pantallas del aplicativo

## Pantalla principal - Listado de categorías
![AppPrincipal](varios/app/store.PNG)

## Listado de productos al seleccionar una categoría
![AppPrincipal](varios/app/store2.PNG)

## Detalle del producto antes de agregarlo al carrito de compras
![AppPrincipal](varios/app/store3.PNG)

## Carrito de compras
![AppPrincipal](varios/app/store4.PNG)

## Listado de órdenes guardadas
![AppPrincipal](varios/app/store5.PNG)
