const { gql } = require('apollo-server');

const jugadorTypeDefs = gql `
    type Jugador {
        nombre: String!
        fechaNacimiento: String!
        convJugadas: Int
    }
    extend type Query {
        jugadorByNombre(username: String!): Jugador!
    }
`;
module.exports = jugadorTypeDefs;