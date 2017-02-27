"use strict";

const State = require ('./state');
const Fsm = require ('./fsm');

/**
 * Estado Descansado
 */
class Descansado extends State {
  accepts(event,_current) {
    return event.msg === "herido" && _current === "Descansando";
  }
  
  onInjured (eventEmitter, fsm){
    console.log(`${fsm.owner().id()} ha sido herido - MOLESTOOO!!...`);
  }

  onElementoutArea (eventEmitter, fsm){
    console.log(`${fsm.owner().id()} se encuentra fuera de su area - MOLESTOOO!!...`);
  }

  onEnter(eventEmitter, fsm) {
    fsm.owner().on();
    console.log(`${fsm.owner().id()} - Descansando...`);
  }
  
  onUpdate(eventEmitter, fsm) {
    console.log(`${fsm.owner().id()} - Descansando`);
  }
}


/**
 * Estado Enojado
 */
class Enojado extends State {
  accepts(event) {
    return event.msg === "on";
  }
  
  onEnter(eventEmitter, fsm) {
    fsm.owner().on();
    console.log(`${fsm.owner().id()} - Enojado...`);
  }
  
  onUpdate(eventEmitter, fsm) {
    console.log(`${fsm.owner().id()} - MOLESTO`);
  }
}


/**
 * Estado Molesto
 */
class Molesto extends State {
  accepts(event) {
    return event.msg === "on";
  }
  
  onEnter(eventEmitter, fsm) {
    fsm.owner().on();
    console.log(`${fsm.owner().id()} - Molesto...`);
  }
  
  onUpdate(eventEmitter, fsm) {
    console.log(`${fsm.owner().id()} - Molesto`);
  }
}


/**
 * Estado Furioso
 */
class Furioso extends State {
  accepts(event) {
    return event.msg === "on";
  }
  
  onEnter(eventEmitter, fsm) {
    fsm.owner().on();
    console.log(`${fsm.owner().id()} - Furioso...`);
  }
  
  onUpdate(eventEmitter, fsm) {
    console.log(`${fsm.owner().id()} - MOLESTO`);
  }
  
}


/**
 * Los estados pueden ser de tipo Singleton.
 */
const STATES = [new Descansado(), new Enojado(),new Molesto(),new Furioso()];

/**
 * Agentes
 */
module.exports = class NPC {
 
  constructor(id) {
    this._id = id;
    this._fsm = new Fsm(this, STATES);
  }

  id() {
    return this._id;
  }
  /**
   * No mucho q ver, pero si fuera un juego por ejemplo el agente estaria
   * alumbrando el area.
   */
  on() {
    this.status = "on";
  }

  off() {
    this.status = "off";
  }
}


