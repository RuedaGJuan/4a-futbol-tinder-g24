const convocatoriaResolver = {
    Query: {
        convocatoriaByLocalidad: async (_, { localidad }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken)
                return dataSources.convocatoriaAPI.convocatoriaByLocalidad(localidad)
            else
                return null

        },
        convocatoriaByFecha: async (_, { fecha }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken)
                return dataSources.convocatoriaAPI.convocatoriaByFecha(fecha)
            else
                return null

        }
    },
    Mutation: {
        createConvocatoria: async (_, { convocatoria }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken)
                return dataSources.convocatoriaAPI.createConvocatoria(convocatoria)
            else
                return null
        }



        }
    
};
module.exports = convocatoriaResolver;