-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER mod3_vue_review_owner
WITH PASSWORD 'mod3_vue_review_pass';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO mod3_vue_review_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO mod3_vue_review_owner;

CREATE USER mod3_vue_review_appuser
WITH PASSWORD 'mod3_vue_review_pass';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO mod3_vue_review_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO mod3_vue_review_appuser;
