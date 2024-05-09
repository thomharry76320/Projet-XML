DROP TABLE cv;
CREATE TABLE cv (
    id SERIAL PRIMARY KEY
);

DROP TABLE identite;
CREATE TABLE identite (
    cv_id INT NOT NULL,
    nom VARCHAR(32) NOT NULL,
    prenom VARCHAR(32) NOT NULL,
    tel VARCHAR(25),
    genre VARCHAR(10),
    email VARCHAR(128),
    PRIMARY KEY (nom, prenom, tel),
    FOREIGN KEY (cv_id) REFERENCES cv(id) ON DELETE CASCADE
);

DROP TABLE objectif;
CREATE TABLE objectif (
    id SERIAL PRIMARY KEY,
    cv_id INT NOT NULL,
    obj VARCHAR(128),
    statut VARCHAR(10),
    FOREIGN KEY (cv_id) REFERENCES cv(id) ON DELETE CASCADE
);

DROP TABLE diplome;
CREATE TABLE diplome(
    id SERIAL PRIMARY KEY,
    cv_id INT NOT NULL,
    date VARCHAR(20) NOT NULL,
    institut VARCHAR(32),
    niveau INT NOT NULL,
    FOREIGN KEY (cv_id) REFERENCES cv(id) ON DELETE CASCADE
);

DROP TABLE titre;
CREATE TABLE titre(
    id SERiAL PRIMARY KEY,
    diplome_id INT NOT NULL,
    titre VARCHAR(128),
    FOREIGN KEY (diplome_id) REFERENCES diplome(id) ON DELETE CASCADE
);

DROP TABLE certification;
CREATE TABLE certification(
    id SERIAL PRIMARY KEY,
    cv_id INT NOT NULL,
    datedeb VARCHAR(20) NOT NULL,
    datefin VARCHAR(20),
    titre VARCHAR(32),
    FOREIGN KEY (cv_id) REFERENCES cv(id) ON DELETE CASCADE
);

DROP TABLE langue;
CREATE TABLE langue(
    id SERIAL PRIMARY KEY,
    cv_id INT NOT NULL,
    lang VARCHAR(5) NOT NULL,
    cert VARCHAR(10) NOT NULL,
    nivs VARCHAR(5),
    nivi INT,
    FOREIGN KEY (cv_id) REFERENCES cv(id) ON DELETE CASCADE
);

DROP TABLE autre;
CREATE TABLE autre(
    id SERIAL PRIMARY KEY,
    cv_id INT NOT NULL,
    titre VARCHAR(32) NOT NULL,
    comment VARCHAR(128),
    FOREIGN KEY (cv_id) REFERENCES cv(id) ON DELETE CASCADE
);

DROP TABLE detail;
CREATE TABLE detail(
    id SERIAL PRIMARY KEY,
    cv_id INT NOT NULL,
    datedeb VARCHAR(20) NOT NULL,
    datefin VARCHAR(20),
    titre VARCHAR(32),
    FOREIGN KEY (cv_id) REFERENCES cv(id) ON DELETE CASCADE
);
