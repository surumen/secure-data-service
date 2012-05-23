package org.slc.sli.api.resources.v1.entity;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.slc.sli.api.config.EntityDefinitionStore;
import org.slc.sli.api.representation.EntityBody;
import org.slc.sli.api.resources.v1.DefaultCrudEndpoint;
import org.slc.sli.client.constants.ResourceNames;
import org.slc.sli.client.constants.v1.ParameterConstants;
import org.slc.sli.client.constants.v1.PathConstants;

/**
 * This event entity represents actions taken by an
 * education organization after a disruptive event that
 * is recorded as a discipline incident.
 *
 * @author slee
 *
 */
@Path(PathConstants.V1 + "/" + PathConstants.DISCIPLINE_ACTIONS)
@Component
@Scope("request")
public class DisciplineActionResource extends DefaultCrudEndpoint {

    @Autowired
    public DisciplineActionResource(EntityDefinitionStore entityDefs) {
        super(entityDefs, ResourceNames.DISCIPLINE_ACTIONS);
    }

    /**
     * Returns all $$disciplineActions$$ entities for which the logged in User has permission and context.
     *
     * @param offset
     *            starting position in results to return to user
     * @param limit
     *            maximum number of results to return to user (starting from offset)
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return result of CRUD operation
     */
    @Override
    @GET
    public Response readAll(@QueryParam(ParameterConstants.OFFSET) @DefaultValue(ParameterConstants.DEFAULT_OFFSET) final int offset,
            @QueryParam(ParameterConstants.LIMIT) @DefaultValue(ParameterConstants.DEFAULT_LIMIT) final int limit,
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        return super.readAll(offset, limit, headers, uriInfo);
    }

    /**
     * Create a new $$disciplineActions$$ entity.
     *
     * @param newEntityBody
     *            entity data
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *              URI information including path and query parameters
     * @return result of CRUD operation
     * @response.param {@name Location} {@style header} {@type
     *                 {http://www.w3.org/2001/XMLSchema}anyURI} {@doc The URI where the created
     *                 item is accessible.}
     */
    @Override
    @POST
    public Response create(final EntityBody newEntityBody,
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        return super.create(newEntityBody, headers, uriInfo);
    }

    /**
     * Get a single $$disciplineActions$$ entity.
     *
     * @param disciplineActionId
     *            The Id of the $$disciplineActions$$.
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return A single disciplineIncident entity
     */
    @Override
    @GET
    @Path("{" + ParameterConstants.DISCIPLINE_ACTION_ID + "}")
    public Response read(@PathParam(ParameterConstants.DISCIPLINE_ACTION_ID) final String disciplineActionId,
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        return super.read(disciplineActionId, headers, uriInfo);
    }

    /**
     * Delete a $$disciplineActions$$ entity.
     *
     * @param disciplineActionId
     *            The Id of the $$disciplineActions$$.
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return Returns a NOT_CONTENT status code
     * @response.representation.204.mediaType HTTP headers with a Not-Content status code.
     */
    @Override
    @DELETE
    @Path("{" + ParameterConstants.DISCIPLINE_ACTION_ID + "}")
    public Response delete(@PathParam(ParameterConstants.DISCIPLINE_ACTION_ID) final String disciplineActionId,
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        return super.delete(disciplineActionId, headers, uriInfo);
    }

    /**
     * Update an existing $$disciplineActions$$ entity.
     *
     * @param disciplineActionId
     *            The id of the $$disciplineActions$$.
     * @param newEntityBody
     *            entity data
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return Response with a NOT_CONTENT status code
     * @response.representation.204.mediaType HTTP headers with a Not-Content status code.
     */
    @Override
    @PUT
    @Path("{" + ParameterConstants.DISCIPLINE_ACTION_ID + "}")
    public Response update(@PathParam(ParameterConstants.DISCIPLINE_ACTION_ID) final String disciplineActionId,
            final EntityBody newEntityBody,
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        return super.update(disciplineActionId, newEntityBody, headers, uriInfo);
    }
}
