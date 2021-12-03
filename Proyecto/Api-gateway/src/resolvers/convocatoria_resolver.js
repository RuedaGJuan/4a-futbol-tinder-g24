const convocatoriaResolver = {
    Query: {
        convocatoriaById: async (_, { username }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (username == usernameToken)
                return dataSources.accountAPI.convocatoriaById(username)
            else
                return null

        }
    },
    Mutation: {
        createConvocatoria: async (_, { convocatoria }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            
        }
    }
};
module.exports = convocatoriaResolver;