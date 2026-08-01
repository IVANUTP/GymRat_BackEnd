UPDATE tbl_objetivos_rutina
SET descripcion = CASE nombre
                      WHEN 'Hipertrofia' THEN 'Aumento de masa muscular mediante volumen de entrenamiento y sobrecarga progresiva.'
                      WHEN 'Fuerza' THEN 'Mejora de la capacidad para levantar cargas altas mediante entrenamiento de intensidad elevada.'
                      WHEN 'Resistencia' THEN 'Incremento de la resistencia muscular y capacidad de mantener esfuerzo prolongado.'
                      WHEN 'Pérdida de grasa' THEN 'Reducción del porcentaje de grasa corporal conservando masa muscular.'
                      WHEN 'Potencia' THEN 'Mejora de explosividad, velocidad y producción máxima de fuerza.'
                      WHEN 'Rehabilitación' THEN 'Recuperación funcional, fortalecimiento progresivo y prevención de lesiones.'
                      WHEN 'Movilidad' THEN 'Mejora del rango articular, flexibilidad y control del movimiento.'
    END;