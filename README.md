# Módulo de Inventario con Spring Boot - Taller Lizardo Car

Evidencia GA7-220501096-AA3-EV01 · Codificación de módulos del software
stand-alone, web y móvil.

Versión del módulo de Inventario construida con el framework **Spring Boot**
(Spring MVC + Spring Data JPA + Thymeleaf), como evolución de los módulos ya
codificados en las evidencias anteriores:

- AA2-EV01: módulo de consola con JDBC puro.
- AA2-EV02: módulo web con Servlets y JSP puros (sin framework).
- **AA3-EV01 (este proyecto): módulo web con el framework Spring Boot**,
  que reemplaza el JDBC manual por Spring Data JPA como herramienta de
  almacenamiento de datos.

## Por qué Spring Boot

Spring Boot se seleccionó por ser el framework de desarrollo web en Java
más utilizado en la industria y el que suele verse después de Servlets y
JSP puros en la formación. Aporta, entre otras cosas:

- Un servidor Tomcat embebido (no hay que instalar ni configurar Tomcat aparte).
- Enrutamiento declarativo con anotaciones (@GetMapping, @PostMapping) en
  lugar de un switch manual sobre un parámetro de acción.
- **Spring Data JPA** como herramienta de almacenamiento de datos: los
  repositorios (interfaces que extienden JpaRepository) generan el CRUD
  automáticamente, sin escribir sentencias SQL a mano.
- Inyección de dependencias, que facilita separar el proyecto en capas
  (controlador, servicio, repositorio, modelo).

## Requisitos

- Java JDK 17 o superior.
- Maven (para descargar Spring Boot y sus dependencias desde Maven Central).
- Un servidor MySQL accesible en `localhost:3306`.
- Conexión a internet la primera vez que se compile (Maven descarga
  automáticamente Spring Boot; a partir de ahí queda en caché local).

## Estructura del proyecto (arquitectura por capas)

```
src/main/java/com/tallerlizardocar/
|-- TallerLizardoCarApplication.java   (arranque de Spring Boot)
|-- modelo/Producto.java               (entidad JPA)
|-- repositorio/ProductoRepositorio.java  (Spring Data JPA)
|-- servicio/ProductoServicio.java     (logica de negocio)
`-- controlador/ProductoControlador.java  (rutas GET y POST)

src/main/resources/
|-- application.properties             (conexion a MySQL, puerto, JPA)
|-- templates/listar.html               (Thymeleaf)
|-- templates/formulario.html           (Thymeleaf)
`-- static/css/estilos.css
```

## Rutas del módulo (GET y POST)

| Acción | Método | Ruta |
|---|---|---|
| Listar productos | GET | `/productos` |
| Formulario nuevo producto | GET | `/productos/nuevo` |
| Formulario de edición | GET | `/productos/editar/{id}` |
| Guardar (crear o actualizar) | POST | `/productos/guardar` |
| Eliminar producto | GET | `/productos/eliminar/{id}` |

## Cómo ejecutar el proyecto

1. Ejecutar `database/script-base-datos.sql` en su servidor MySQL (si ya
   la creó en la evidencia AA2-EV01/EV02, puede reutilizar esa misma base
   de datos: no es necesario volver a crearla).
2. Ajustar usuario/contraseña en `src/main/resources/application.properties`
   si son distintos a `taller_app` / `TallerLizardo2026*`.
3. Compilar y ejecutar con Maven:
   ```
   mvn spring-boot:run
   ```
4. Abrir en el navegador: `http://localhost:8080/productos`

**En IntelliJ:** al abrir la carpeta del proyecto (con el `pom.xml`),
IntelliJ reconoce automáticamente la clase `TallerLizardoCarApplication`
como punto de arranque. Basta con darle clic al botón ▶ verde que aparece
junto a su método `main`, sin necesidad de configurar Tomcat ni ningún
plugin adicional (Spring Boot trae su propio servidor embebido).

## Advertencia sobre la verificación de este proyecto

A diferencia de los módulos de las evidencias AA2-EV01 y AA2-EV02 (que sí
se compilaron y ejecutaron de extremo a extremo antes de entregarse), este
módulo con Spring Boot no pudo probarse en el entorno de generación de esta
evidencia porque sus dependencias solo están disponibles en Maven Central,
un repositorio inaccesible desde ese entorno. El código sigue las
convenciones estándar y bien documentadas de Spring Boot, pero se
recomienda compilarlo y probarlo con atención en su propio computador
(con conexión a internet) antes de entregarlo.

## Estándar de codificación aplicado

Se mantiene el mismo estándar definido en la evidencia AA1-EV02: paquetes
en minúsculas (com.tallerlizardocar.controlador), clases en PascalCase
(ProductoServicio), métodos y variables en camelCase (buscarPorId,
productoServicio), y comentarios tipo Javadoc explicando el propósito de
cada clase y método.
