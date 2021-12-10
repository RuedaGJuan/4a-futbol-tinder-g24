const { gql } = require('apollo-server');

const jugadorTypeDefs = gql `
    type Jugador {
        nombre: String!
        edad: Int!
        convJugadas: Int
    }
    extend type Query {
        jugadorByNombre(nombre: String!): Jugador!
    }
`;
module.exports = jugadorTypeDefs;