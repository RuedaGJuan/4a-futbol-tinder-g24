const jugadorResolver = {
    Query: {
        jugadorByNombre: async (_, { username }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (username == usernameToken)
                return await dataSources.jugadorAPI.jugadorByNombre(username)
            else
                return null

        },
    },
    Mutation: {}
};
module.exports = jugadorResolver;