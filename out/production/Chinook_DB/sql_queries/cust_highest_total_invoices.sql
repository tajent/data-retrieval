/* Works if no duplicate of total, limiting to first row in descending order
SELECT SUM("Total"), "Customer"."FirstName", "Customer"."LastName", "Invoice"."CustomerId"  
FROM "Customer", "Invoice" 
WHERE "Invoice"."CustomerId" = "Customer"."CustomerId"
GROUP BY "Customer"."FirstName", "Customer"."LastName", "Invoice"."CustomerId" 
ORDER BY 1
DESC LIMIT 1;*/

—- Better, as allows for duplicates totals
WITH highest_total AS (
    SELECT SUM("Total") as sum_totals, "Customer"."FirstName", "Customer"."LastName", "Invoice"."CustomerId"  
	FROM "Customer", "Invoice" 
	WHERE "Invoice"."CustomerId" = "Customer"."CustomerId"
	GROUP BY "Customer"."FirstName", "Customer"."LastName", "Invoice"."CustomerId"
) 
SELECT *
FROM highest_total
WHERE sum_totals = (SELECT max(sum_totals) 
                  FROM highest_total);


