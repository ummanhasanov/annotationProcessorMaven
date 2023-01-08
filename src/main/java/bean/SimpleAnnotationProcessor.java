/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author Umman Hasan
 */
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
//import jdk.nashorn.internal.ir.annotations.Immutable;

@SupportedAnnotationTypes("bean.WritingStyle")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class SimpleAnnotationProcessor extends AbstractProcessor
{

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
        System.out.println("processor is executed");
        for (final Element element : roundEnv.getElementsAnnotatedWith(WritingStyle.class)) {
            String varName = element.getSimpleName().toString();
            if (!varName.startsWith("teacher")) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "variable must start with teacher");

            }
//            if (element instanceof TypeElement) {
//                final TypeElement typeElement = (TypeElement) element;
//
//                for (final Element eclosedElement : typeElement.getEnclosedElements()) {
//                    if (eclosedElement instanceof VariableElement) {
//                        final VariableElement variableElement = (VariableElement) eclosedElement;
//
//                        if (variableElement.getConstantValue() == null) {
//                            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "variable must start with teacher");
//                        }
//                    }
//                }
//            }
        }
        return true;
    }

}
