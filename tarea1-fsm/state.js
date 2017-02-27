"use strict";
/**
 * Contrato de implementacion para un estado
 */
module.exports = class State {
  constructor() {
  }

  /**
   * Si el estado reconoce el mensaje regresa verdadero.
   */
  accepts(event,_current) {
    return false;
  }
  /**
   * Se llama cada vez que el estado se activa
   */
  onEnter(eventEmitter, fsm) {     
  }

  onInjured(eventEmitter, fsm) {     
  }

  onElementoutArea(eventEmitter, fsm) {     
  }

  /**
   * Si el estado esta activo se llama con cada ciclo
   */
  onUpdate(eventEmitter, fsm) {     
  }
  /**
   * Se llama cada vez que el estado se desactiva
   */
  onExit(eventEmitter, fsm) {     
  }
}