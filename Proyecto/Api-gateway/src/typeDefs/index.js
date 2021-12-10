//Se llama al typedef (esquema) de cada submodulo
const jugadorTypeDefs = require('./jugador_type_defs');
const convocatoriaTypeDefs = require('./convocatoria_type_defs');
const authTypeDefs = require('./auth_type_defs');
//Se unen
const schemasArrays = [authTypeDefs, jugadorTypeDefs, convocatoriaTypeDefs];
//Se exportan
module.exports = schemasArrays;