const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');

class ConvocatoriaAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.convocatoria_api_url;
    }
    async createConvocatoria(convocatoria) {
        convocatoria = new Object(JSON.parse(JSON.stringify(convocatoria)));
        return await this.post('/convocatoria', convocatoria);
    }
    async convocatoriaByLocalidad(localidad) {
        return await this.get(`/convocatoriaslocalidad/${localidad}`);
    }
    async convocatoriaByFecha(fecha) {
        return await this.get(`/convocatoriasfecha/${fecha}`);
    }
    async convocatoriaTodas() {
        return await this.get(`/convocatorias`);
    }
}
module.exports = ConvocatoriaAPI;