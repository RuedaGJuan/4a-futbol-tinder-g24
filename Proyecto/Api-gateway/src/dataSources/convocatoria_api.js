const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');

class ConvocatoriaAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.convocatoria_api_url;
    }
    async createConvocatoria(convocatoria) {
        convocatoria = new Object(JSON.parse(JSON.stringify(convocatoria)));
        return await this.post('/convocatorias', convocatoria);
    }
    async convocatoriaById(id) {
        return await this.get(`/convocatorias/${id}`);
    }
}
module.exports = ConvocatoriaAPI;