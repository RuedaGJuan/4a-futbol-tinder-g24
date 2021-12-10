const jugadorResolver = {
    Query: {
        jugadorByNombre: async (_, { nombre }, { dataSources, userIdToken }) => {
            nameToken = (await dataSources.authAPI.getUser(userIdToken)).name
            if (nombre == nameToken)
                return await dataSources.jugadorAPI.jugadorByNombre(nombre)
            else
                return null

        },
    },
    Mutation: {}
};
module.exports = jugadorResolver;