const jugadorResolver = require('./jugador_resolver');
const convocatoriaResolver = require('./convocatoria_resolver');
const authResolver = require('./auth_resolver');
const lodash = require('lodash');
const resolvers = lodash.merge(jugadorResolver, convocatoriaResolver, authResolver);
module.exports = resolvers;