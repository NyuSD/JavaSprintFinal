CREATE TABLE users (
    userId SERIAL PRIMARY KEY,
    userName VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    address VARCHAR(255),
    phoneNumber VARCHAR(50),
    role VARCHAR(20)
);

CREATE TABLE memberships (
    membershipId SERIAL PRIMARY KEY,
    membershipType VARCHAR(50),
    membershipDescription VARCHAR(255),
    membershipCost DECIMAL(10,2),
    memberId INT REFERENCES users(userId)
);

CREATE TABLE workoutclasses (
    workoutClassId SERIAL PRIMARY KEY,
    workoutClassType VARCHAR(50),
    workoutClassDescription VARCHAR(255),
    trainerId INT REFERENCES users(userId)
);
