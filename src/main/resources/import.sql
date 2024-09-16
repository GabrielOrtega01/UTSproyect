-- Administrador
INSERT INTO administradores(usuario, contra) VALUES('admin', '123');

-- Coordinador 3
INSERT INTO coordinadores (cedula, nombre, apellido, contra, telefono) VALUES (1003, 'Laura', 'García', 'pass3344', '3158765432');

-- Coordinador 4
INSERT INTO coordinadores (cedula, nombre, apellido, contra, telefono) VALUES (1004, 'Pedro', 'Martínez', 'pass4455', '3206547890');

-- Director 2
INSERT INTO directores (cedula, nombre, apellido, contra, telefono) VALUES (1006, 'Ana', 'López', 'abc123', '3109876543');

-- Evaluador 2
INSERT INTO evaluadores (cedula, nombre, apellido, contra, telefono) VALUES (1007, 'Luis', 'Ramírez', 'pass567', '123456789');

-- Estudiante 2
INSERT INTO estudiantes (cedula, nombre, apellido, contra, telefono, carrera_estudiando) VALUES (1008, 'Camila', 'Gómez', 'pass789012', '987654321', 'Ingeniería Civil');

-- Proyectos con asignaciones
INSERT INTO proyectos (anteproyecto, descripcion, estado_director, radicado_anteproyecto, estado_evaluador, estado_final, radicado_comite, calificacion, director_id, evaluador_id, estudiante_id) 
VALUES 
('Desarrollo de una app para gestión de tareas', 'El proyecto busca crear una aplicación que ayude a gestionar tareas diarias y aumentar la productividad.', 'Pendiente', 'URL', 'Sin Asignar', 'Sin Asignar', 'URL', '0.0', 1006, 1007, 1008);

INSERT INTO proyectos (anteproyecto, descripcion, estado_director, radicado_anteproyecto, estado_evaluador, estado_final, radicado_comite, calificacion, director_id, evaluador_id, estudiante_id) 
VALUES 
('Investigación sobre Inteligencia Artificial', 'Este proyecto explora las aplicaciones de la inteligencia artificial en la educación y la salud.', 'Pendiente', 'URL', 'Sin Asignar', 'Sin Asignar', 'URL', '0.0', 1006, 1007, 1008);

INSERT INTO proyectos (anteproyecto, descripcion, estado_director, radicado_anteproyecto, estado_evaluador, estado_final, radicado_comite, calificacion, director_id, evaluador_id, estudiante_id) 
VALUES 
('Análisis de la economía circular', 'El proyecto estudia cómo la economía circular puede ayudar a mejorar la sostenibilidad en las empresas.', 'Pendiente', 'URL', 'Sin Asignar', 'Sin Asignar', 'URL', '0.0', 1006, 1007, 1008);

INSERT INTO proyectos (anteproyecto, descripcion, estado_director, radicado_anteproyecto, estado_evaluador, estado_final, radicado_comite, calificacion, director_id, evaluador_id, estudiante_id) 
VALUES 
('Desarrollo de una aplicación móvil para salud mental', 'Esta aplicación busca ayudar a las personas a gestionar su bienestar emocional a través de técnicas de mindfulness.', 'Pendiente', 'URL', 'Sin Asignar', 'Sin Asignar', 'URL', '0.0', 1006, 1007, 1008);

INSERT INTO proyectos (anteproyecto, descripcion, estado_director, radicado_anteproyecto, estado_evaluador, estado_final, radicado_comite, calificacion, director_id, evaluador_id, estudiante_id) 
VALUES 
('Plan de marketing para productos orgánicos', 'El proyecto se centra en crear estrategias para el lanzamiento de una línea de productos alimenticios orgánicos.', 'Pendiente', 'URL', 'Sin Asignar', 'Sin Asignar', 'URL', '0.0', 1006, 1007, 1008);
