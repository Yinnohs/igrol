package com.yinnohs.igrol.auth;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchitectureAuthPackageTest {

    private final String BASE_PACKAGE = "com.yinnohs.igrol";
    private final String AUTH_PACKAGE = ".auth";
    private final String JAVA_PACKAGES = "java..";
    private final String DOMAIN_PACKAGES = BASE_PACKAGE + AUTH_PACKAGE +  ".domain..";
    private final String APPLICATION_PACKAGES = BASE_PACKAGE + AUTH_PACKAGE + ".application..";
    private final String USER_DOMAIN = BASE_PACKAGE + ".user.domain..";
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
    public void ensure_application_classes_only_depends_on_java_std_library_lombok_domain_and_user_domain(){
        ArchRule domainRule = noClasses().that()
                .resideInAnyPackage(APPLICATION_PACKAGES)
                .should()
                .dependOnClassesThat()
                .resideOutsideOfPackages(DOMAIN_PACKAGES, JAVA_PACKAGES, LOMBOK, APPLICATION_PACKAGES, USER_DOMAIN);

        domainRule.allowEmptyShould(true).check(importedClasses);
    }
}
