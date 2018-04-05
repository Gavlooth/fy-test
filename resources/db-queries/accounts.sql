--example of hugsql functions

-- :name read-accounts :query :1
-- :doc Get an account by id as map. If not found return nil.
SELECT * FROM accounts
WHERE email = :email

-- :name create-accounts :insert
-- :doc Create an account and return the created row as a map
INSERT INTO accounts(email, encrypted_password)
VALUES (:email, :encrypted_password)

