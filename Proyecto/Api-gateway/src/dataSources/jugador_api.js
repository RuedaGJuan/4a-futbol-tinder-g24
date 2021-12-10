const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');

class JugadorAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.jugador_api_url;
    }
    async createJugador(jugador) {
        jugador = new Object(JSON.parse(JSON.stringify(jugador)));
        return await this.post('/jugador', jugador);
    }
    async jugadorByNombre(username) {
        return await this.get(`/jugador/${username}/`);
    }
}
module.exports = JugadorAPI;