import binding_example


def test_binding_example():
    res1 = binding_example.add(2, 4)
    res2 = binding_example.sum_as_string(2, 4)

    assert res1 == 6
    assert res2 == "6"
