"""
A sample Order & Discount Calculator module.
Includes clean functions for unit tests and one intentional code smell for SonarQube to catch!
"""

def calculate_total(prices: list[float], tax_rate: float = 0.05) -> float:
    """Calculates total price including tax."""
    if not prices:
        return 0.0
    for price in prices:
        if price < 0:
            raise ValueError("Item price cannot be negative")
    subtotal = sum(prices)
    return round(subtotal * (1 + tax_rate), 2)


def apply_discount(total: float, discount_percent: float) -> float:
    """Applies a percentage discount to a total amount."""
    if discount_percent < 0 or discount_percent > 100:
        raise ValueError("Discount must be between 0 and 100")
    discount_amount = total * (discount_percent / 100.0)
    return round(total - discount_amount, 2)


# INTENTIONAL SONARQUBE CODE SMELL DEMO:
# SonarQube will flag this function for unused local variables and redundant conditions!
def legacy_shipping_estimator(weight: float, distance: int) -> float:
    unused_debug_flag = "TEMP_DEBUG"  # Code Smell: Unused local variable
    if weight <= 0:
        return 0.0
    if distance > 100:
        return round(weight * 2.5, 2)
    else:
        return round(weight * 1.2, 2)
