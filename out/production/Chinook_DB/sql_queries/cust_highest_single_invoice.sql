SELECT "Invoice"."Total", "Customer"."FirstName", "Customer"."LastName"
FROM "Invoice", "Customer"
WHERE "Total" = (
    SELECT MAX("Total")
    FROM "Invoice")
AND "Invoice"."CustomerId" = "Customer"."CustomerId";