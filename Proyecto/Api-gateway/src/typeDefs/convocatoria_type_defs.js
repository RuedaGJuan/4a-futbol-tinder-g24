const { gql } = require('apollo-server');
const convocatoriaTypeDefs = gql `
    type Convocatoria {
        id: String!
        jugEquip1: String!
        jugEquip2: String!
        fecha: String!
        hora: String!
        localidad : String!
        posiciones: String
    }
    input ConvocatoriaInput {
        jugEquip1: String!
        jugEquip2: String!
        fecha: String!
        hora: String!
        localidad : String!
        posiciones: String
    }
    extend type Query {
        convocatoriaById(id: String!): Convocatoria
    }
    extend type Mutation {
        createConvocatoria(convocatoria: ConvocatoriaInput!): Convocatoria
    }
`;
module.exports = convocatoriaTypeDefs;