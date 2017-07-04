/*
SELECT "FirstName", "LastName", (SELECT COUNT(*) 
								FROM "Invoice" 
								WHERE "Invoice"."CustomerId" = "Customer"."CustomerId") 
AS number 
FROM "Customer" 
GROUP BY "CustomerId";
*/

--This is better, as only shows maximums
WITH counters AS (
    SELECT "Customer"."FirstName", "Customer"."LastName", "Invoice"."CustomerId",
           count(*) as counting
    FROM "Customer", "Invoice"
    WHERE "Invoice"."CustomerId" = "Customer"."CustomerId"
    GROUP BY "Customer"."FirstName", "Customer"."LastName", "Invoice"."CustomerId"
) 
SELECT *
FROM counters
WHERE counting = (SELECT max(counting) 
                  FROM counters);

