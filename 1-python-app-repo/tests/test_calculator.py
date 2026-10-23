import pytest
from app.calculator import calculate_total, apply_discount, legacy_shipping_estimator

def test_calculate_total_standard():
    assert calculate_total([100.0, 200.0], tax_rate=0.10) == 330.0

def test_calculate_total_empty():
    assert calculate_total([]) == 0.0

def test_calculate_total_negative_raises_error():
    with pytest.raises(ValueError, match="Item price cannot be negative"):
        calculate_total([50.0, -10.0])

def test_apply_discount_valid():
    assert apply_discount(200.0, 15) == 170.0

def test_apply_discount_invalid_range():
    with pytest.raises(ValueError, match="Discount must be between 0 and 100"):
        apply_discount(100.0, 120)

def test_legacy_shipping_estimator():
    assert legacy_shipping_estimator(10.0, 150) == 25.0
    assert legacy_shipping_estimator(10.0, 50) == 12.0
    assert legacy_shipping_estimator(0, 50) == 0.0
