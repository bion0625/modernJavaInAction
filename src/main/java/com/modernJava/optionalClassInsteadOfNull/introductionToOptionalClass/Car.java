package com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass;

import java.util.Optional;

public class Car {
    private Optional<Insurance> insurance  = Optional.empty();
    public Optional<Insurance> getInsurance() {
        return this.insurance;
    }
    public void setInsurance(Insurance insurance) {
        this.insurance = Optional.ofNullable(insurance);
    }
}
