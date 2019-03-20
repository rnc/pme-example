

// This grab annotation ( http://docs.groovy-lang.org/latest/html/api/groovy/lang/Grab.html )
// is not actually needed at runtime (as PME will automatically provide the dependencies) but
// its useful during development as IntelliJ can then correctly locate the dependencies for
// the project and provide completion assist.
@Grab('org.commonjava.maven.ext:pom-manipulation-core:3.5')

import org.commonjava.maven.ext.core.groovy.PMEBaseScript
import org.commonjava.maven.ext.core.groovy.PMEInvocationPoint
import org.commonjava.maven.ext.core.groovy.InvocationStage
import org.commonjava.maven.ext.core.groovy.BaseScript

@PMEInvocationPoint(invocationPoint = InvocationStage.FIRST)
@PMEBaseScript BaseScript pme


println "Altering project " + pme.getGAV()
pme.inlineProperty(pme.getProject(), "org.apache.james:apache-mime4j")
pme.getProject().getModel().getProperties().setProperty("shared.version", "1.7.25")
