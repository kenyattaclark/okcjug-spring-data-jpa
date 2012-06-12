package org.okcjug.springdatajpa.predicates;

import org.okcjug.springdatajpa.domain.QAssociate;

import com.mysema.query.types.expr.BooleanExpression;

public class AssociatePredicate {

    public static BooleanExpression byLastName(final String lastName) {
        QAssociate associate = QAssociate.associate;
        return associate.lastName.eq(lastName);
    }
    
    public static BooleanExpression byFirstName(final String firstName) {
        QAssociate associate = QAssociate.associate;
        return associate.firstName.eq(firstName);
    }
}