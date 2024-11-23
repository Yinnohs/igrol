package com.yinnohs.igrol.user;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;::
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchitectureUserPackageTest {

    private final String BASE_PACKAGE = "com.yinnohs.igrol";
    private final String USER_PACKAGE = ".user";
    private final String JAVA_PACKAGES = "java..";
    private final String DOMAIN_PACKAGES = BASE_PACKAGE + USER_PACKAGE +  ".domain..";
    private final String APPLICATION_PACKAGES = BASE_PACKAGE +  USER_PACKAGE + ".application..";
    private final String LOMBOK = "lombok..";
    private  JavaClasses importedClasses = new ClassFileImporter().importPackages(BASE_PACKAGE);

    @Test
    public void ensure_domain_classes_only_depends_on_java_std_library_and_lombok(){
        ArchRule domainRule = noClasses().that()
                .resideInAnyPackage(DOMAIN_PACKAGES)
                .should()
                .dependOnClassesThat()
                .resideOutsideOfPackages(DOMAIN_PACKAGES, JAVA_PACKAGES, LOMBOK);

        domainRule.allowEmptyShould(true).check(importedClasses);
    }

    @Test
    public void ensure_application_classes_only_depends_on_java_std_library_lombok_domain(){
        ArchRule domainRule = noClasses().that()
                .resideInAnyPackage(APPLICATION_PACKAGES)
                .should()
                .dependOnClassesThat()
                .resideOutsideOfPackages(DOMAIN_PACKAGES, JAVA_PACKAGES, LOMBOK, APPLICATION_PACKAGES);

        domainRule.allowEmptyShould(true).check(importedClasses);
    }
}
