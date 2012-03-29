package org.slc.sli.api.resources.v1.entity;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.slc.sli.api.config.ResourceNames;
import org.slc.sli.api.representation.EntityBody;
import org.slc.sli.api.resources.util.ResourceUtil;
import org.slc.sli.api.resources.v1.CrudEndpoint;
import org.slc.sli.api.resources.v1.HypermediaType;
import org.slc.sli.api.resources.v1.ParameterConstants;
import org.slc.sli.api.resources.v1.PathConstants;

/**
 * Prototype new api end points and versioning
 * 
 * @author jstokes
 * 
 */
@Path(PathConstants.V1 + "/" + PathConstants.PROGRAMS)
@Component
@Scope("request")
@Produces({ MediaType.APPLICATION_JSON, HypermediaType.VENDOR_SLC_JSON })
public class ProgramResource {
    
    /**
     * Logging utility.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProgramResource.class);
    
    /*
     * Interface capable of performing CRUD operations.
     */
    private final CrudEndpoint crudDelegate;

    @Autowired
    public ProgramResource(CrudEndpoint crudDelegate) {
        this.crudDelegate = crudDelegate;
    }

    /**
     * Returns all $$programs$$ entities for which the logged in User has permission and context.
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
    @Produces({ MediaType.APPLICATION_JSON, HypermediaType.VENDOR_SLC_JSON })
    @GET
    public Response readAll(@QueryParam(ParameterConstants.OFFSET) @DefaultValue(ParameterConstants.DEFAULT_OFFSET) final int offset,
            @QueryParam(ParameterConstants.LIMIT) @DefaultValue(ParameterConstants.DEFAULT_LIMIT) final int limit, 
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        ResourceUtil.putValue(headers.getRequestHeaders(), ParameterConstants.LIMIT, limit);
        ResourceUtil.putValue(headers.getRequestHeaders(), ParameterConstants.OFFSET, offset);
        return this.crudDelegate.readAll(ResourceNames.PROGRAMS, headers, uriInfo);
    }

    /**
     * Create a new $$programs$$ entity.
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
     *                 item is accessable.}
     */
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response create(final EntityBody newEntityBody, 
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        return this.crudDelegate.create(ResourceNames.PROGRAMS, newEntityBody, headers, uriInfo);
    }

    /**
     * Get a single $$programs$$ entity.
     * 
     * @param programId
     *            The Id of the $$programs$$.
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return A single program entity
     */
    @GET
    @Path("{" + ParameterConstants.PROGRAM_ID + "}")
    @Produces({ MediaType.APPLICATION_JSON, HypermediaType.VENDOR_SLC_JSON })
    public Response read(@PathParam(ParameterConstants.PROGRAM_ID) final String programId,
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        return this.crudDelegate.read(ResourceNames.PROGRAMS, programId, headers, uriInfo);
    }

    /**
     * Delete a $$programs$$ entity.
     * 
     * @param programId
     *            The Id of the $$programs$$.
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return Returns a NOT_CONTENT status code
     * @response.representation.204.mediaType HTTP headers with a Not-Content status code.
     */
    @DELETE
    @Path("{" + ParameterConstants.PROGRAM_ID + "}")
    public Response delete(@PathParam(ParameterConstants.PROGRAM_ID) final String programId, 
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        return this.crudDelegate.delete(ResourceNames.PROGRAMS, programId, headers, uriInfo);
    }

    /**
     * Update an existing $$programs$$ entity.
     * 
     * @param programId
     *            The id of the $$programs$$.
     * @param newEntityBody
     *            entity data
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return Response with a NOT_CONTENT status code
     * @response.representation.204.mediaType HTTP headers with a Not-Content status code.
     */
    @PUT
    @Path("{" + ParameterConstants.PROGRAM_ID + "}")
    public Response update(@PathParam(ParameterConstants.PROGRAM_ID) final String programId,
            final EntityBody newEntityBody, 
            @Context HttpHeaders headers, @Context final UriInfo uriInfo) {
        return this.crudDelegate.update(ResourceNames.PROGRAMS, programId, newEntityBody, headers, uriInfo);
    }
    
    /**
     * Returns the $$studentProgramAssociations$$ that
     * reference the given $$programs$$
     * 
     * @param programId
     *            The Id of the Program.
     * @param offset
     *            Index of the first result to return
     * @param limit
     *            Maximum number of results to return.
     * @param expandDepth
     *            Number of hops (associations) for which to expand entities.
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return result of CRUD operation
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON, HypermediaType.VENDOR_SLC_JSON })
    @Path("{" + ParameterConstants.PROGRAM_ID + "}" + "/" + PathConstants.STUDENT_PROGRAM_ASSOCIATIONS)
    public Response getStudentProgramAssociations(@PathParam(ParameterConstants.PROGRAM_ID) final String programId,
            @Context HttpHeaders headers, 
            @Context final UriInfo uriInfo) {
        return this.crudDelegate.read(ResourceNames.STUDENT_PROGRAM_ASSOCIATIONS, "programId", programId, headers, uriInfo);
    }
    

    /**
     * Returns the $students$ that are referenced from the $$studentProgramAssociations$$ 
     * that references the given $$programs$$.
     * 
     * @param programId
     *            The Id of the program.
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return result of CRUD operation
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON, HypermediaType.VENDOR_SLC_JSON })
    @Path("{" + ParameterConstants.PROGRAM_ID + "}" + "/" + PathConstants.STUDENT_PROGRAM_ASSOCIATIONS + "/" + PathConstants.STUDENTS)
    public Response getStudentProgramAssociationStudent(@PathParam(ParameterConstants.PROGRAM_ID) final String programId,
            @Context HttpHeaders headers, 
            @Context final UriInfo uriInfo) {
        return this.crudDelegate.read(ResourceNames.STUDENT_PROGRAM_ASSOCIATIONS, "programId", programId, 
                "studentId", ResourceNames.STUDENTS, headers, uriInfo);
    }
    
    /**
     * Returns the $$staffProgramAssociations$$ that
     * reference the given $$programs$$
     * 
     * @param programId
     *            The Id of the program.
     * @param offset
     *            Index of the first result to return
     * @param limit
     *            Maximum number of results to return.
     * @param expandDepth
     *            Number of hops (associations) for which to expand entities.
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return result of CRUD operation
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON, HypermediaType.VENDOR_SLC_JSON })
    @Path("{" + ParameterConstants.PROGRAM_ID + "}" + "/" + PathConstants.STAFF_PROGRAM_ASSOCIATIONS)
    public Response getStaffProgramAssociations(@PathParam(ParameterConstants.PROGRAM_ID) final String programId,
            @Context HttpHeaders headers, 
            @Context final UriInfo uriInfo) {
        return this.crudDelegate.read(ResourceNames.STAFF_PROGRAM_ASSOCIATIONS, "programId", programId, headers, uriInfo);
    }
    

    /**
     * Returns the $staff$ that are referenced from the $$staffProgramAssociations$$ 
     * that references the given $$programs$$.
     * 
     * @param programId
     *            The Id of the program.
     * @param headers
     *            HTTP Request Headers
     * @param uriInfo
     *            URI information including path and query parameters
     * @return result of CRUD operation
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON, HypermediaType.VENDOR_SLC_JSON })
    @Path("{" + ParameterConstants.PROGRAM_ID + "}" + "/" + PathConstants.STAFF_PROGRAM_ASSOCIATIONS + "/" + PathConstants.STAFF)
    public Response getStaffProgramAssociationStaff(@PathParam(ParameterConstants.PROGRAM_ID) final String programId,
            @Context HttpHeaders headers, 
            @Context final UriInfo uriInfo) {
        return this.crudDelegate.read(ResourceNames.STAFF_PROGRAM_ASSOCIATIONS, "programId", programId, 
                "staffId", ResourceNames.STAFF, headers, uriInfo);
    }
    
    
}
