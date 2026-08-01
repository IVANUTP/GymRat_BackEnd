-- V__actualizar_descripciones_tipo_rutina.sql

UPDATE tbl_tipo_rutina
SET descripcion = CASE nombre
                      WHEN 'Full Body' THEN
                          'Entrenamiento donde se trabajan varios grupos musculares en una misma sesión.'
                      WHEN 'Torso Pierna' THEN
                          'División de entrenamiento separando días de tren superior y tren inferior.'
                      WHEN 'Push Pull Legs' THEN
                          'División basada en movimientos de empuje, jalón y pierna.'
                      WHEN 'Bro Split' THEN
                          'Rutina dividida por grupos musculares específicos entrenando uno por día.'
                      WHEN 'Weider' THEN
                          'Sistema tradicional dividido por músculos con alto volumen de entrenamiento.'
                      WHEN 'Fuerza 5x5' THEN
                          'Rutina enfocada en aumentar fuerza mediante ejercicios básicos y progresión de cargas.'
                      WHEN 'Circuito' THEN
                          'Entrenamiento continuo con varios ejercicios orientado a resistencia muscular y acondicionamiento.'

    END
WHERE nombre IN (
                 'Full Body',
                 'Torso Pierna',
                 'Push Pull Legs',
                 'Bro Split',
                 'Weider',
                 'Fuerza 5x5',
                 'Circuito'
    );