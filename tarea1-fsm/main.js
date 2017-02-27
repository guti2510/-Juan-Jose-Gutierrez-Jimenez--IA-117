const eventEmiter = require ('./event-emiter');
const NPC = require ('./NPC');

/**
 * Ciclo principal
 */

new NPC("Tracer");
setInterval(() => {
  eventEmiter.update();
  eventEmiter.send("update");
}, 100);

/**
 * Crear una nuevo bombillo. El agente segrega al sistema solo
 */
//new Light("l1");
/**
 * Codigo de prueba.
 */
var status = false;
setInterval(() => {
    eventEmiter.send("herido","Tracer");
}, 2000)