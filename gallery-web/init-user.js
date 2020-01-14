db.createUser(
    {
        user: "guppy",
        pwd: "guppykang",
        roles: [
            {
                role: "readWrite",
                db: "gallery"
            }
        ]
    }
);