# Write your MySQL query statement below

SELECT 
    stock_name,
    SUM(
        CASE 
            WHEN operation = 'Buy' THEN -price   -- Money out (ouch \U0001f4b8)
            WHEN operation = 'Sell' THEN price   -- Money in (yay \U0001f4b0)
        END
    ) AS capital_gain_loss
FROM Stocks
GROUP BY stock_name;