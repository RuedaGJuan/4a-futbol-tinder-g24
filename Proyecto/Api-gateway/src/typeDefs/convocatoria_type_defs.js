const { gql } = require('apollo-server');
const convocatoriaTypeDefs = gql `
    type Convocatoria {
        id: String!
        jugEquip1: [Int]
        jugEquip2: [Int]
        fecha: String!
        hora: String!
        localidad : String!
        
    }
    input ConvocatoriaInput {
        jugEquip1: [Int]
        jugEquip2: [Int]
        fecha: String!
        hora: String!
        localidad : String!
      
    }
    extend type Query {
        convocatoriaByLocalidad(localidad: String!): [Convocatoria]!
        convocatoriaByFecha(fecha: String!): [Convocatoria]!
        convocatoriaTodas(fecha: String): [Convocatoria]!
    }
    extend type Mutation {
        createConvocatoria(convocatoria: ConvocatoriaInput!): Convocatoria!
    }
`;
module.exports = convocatoriaTypeDefs;