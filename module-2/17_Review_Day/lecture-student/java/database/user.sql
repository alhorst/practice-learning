-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER shelter_owner
WITH PASSWORD 'dogowner';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO shelter_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO shelter_owner;

CREATE USER shelter_appuser
WITH PASSWORD 'doggos';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO shelter_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO shelter_appuser;
