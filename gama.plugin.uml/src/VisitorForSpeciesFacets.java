import gama.api.compilation.descriptions.IDescription.IFacetVisitor;
import gama.api.gaml.expressions.IExpressionDescription;

public class VisitorForSpeciesFacets implements IFacetVisitor {

	GamlToUMLConverter converter;
	String species;

	public VisitorForSpeciesFacets(final GamlToUMLConverter aConverter) {
		this.converter = aConverter;
	}

	@Override
	public boolean process(final String name, final IExpressionDescription exp) {
		if (name.equals(IParser.GAMA_KEYWORD_PARENT)) {
			converter.generalizations.put(species, exp.toString());
		}
		return true;
	}

	public void setSpecies(final String id) {
		this.species = id;
	}

}
